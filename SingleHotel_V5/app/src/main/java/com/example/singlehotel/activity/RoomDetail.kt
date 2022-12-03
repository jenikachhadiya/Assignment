package com.example.singlehotel.activity

import android.annotation.SuppressLint
import android.app.Dialog
import android.app.ProgressDialog
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.webkit.WebView
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import com.github.ornolfr.ratingview.RatingView
import androidx.recyclerview.widget.RecyclerView
import com.example.singlehotel.util.EnchantedViewPager
import com.google.android.material.card.MaterialCardView
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.singlehotel.adapter.SliderRoomDetailAdapter
import com.google.android.material.textview.MaterialTextView
import io.github.inflationx.viewpump.ViewPumpContextWrapper
import com.google.android.material.appbar.MaterialToolbar
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.JsonObject
import com.google.gson.Gson
import com.example.singlehotel.util.API
import com.example.singlehotel.rest.ApiInterface
import com.example.singlehotel.rest.ApiClient
import com.example.singlehotel.response.RoomDetailRP
import com.example.singlehotel.adapter.RoomAmenities
import com.example.singlehotel.activity.BookRoom
import com.example.singlehotel.response.ReviewRP
import com.example.singlehotel.adapter.ReviewAdapter
import androidx.viewpager.widget.ViewPager
import com.example.singlehotel.R
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.button.MaterialButton
import com.example.singlehotel.response.UserReviewRP
import com.example.singlehotel.response.UserReviewSubmitRP
import com.example.singlehotel.util.Method
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception
import java.util.*

class RoomDetail : AppCompatActivity() {
    private var method: Method? = null
    private var progressBar: ProgressBar? = null
    private var progressDialog: ProgressDialog? = null
    private var webViewDes: WebView? = null
    private var webViewRules: WebView? = null
    private var imageViewRating: ImageView? = null
    private var ratingView: RatingView? = null
    private var recyclerViewRa: RecyclerView? = null
    private var viewPager: EnchantedViewPager? = null
    private var cardViewBookNow: MaterialCardView? = null
    private var conMain: ConstraintLayout? = null
    private var conNoData: ConstraintLayout? = null
    private var conRating: ConstraintLayout? = null
    private var sliderRoomDetailAdapter: SliderRoomDetailAdapter? = null
    private var textViewRoomName: MaterialTextView? = null
    private var textViewPrice: MaterialTextView? = null
    private var textViewTotalRate: MaterialTextView? = null
    private var timer: Timer? = null
    val DELAY_MS: Long = 500 //delay in milliseconds before task is to be executed
    val PERIOD_MS: Long = 3000
    val handler = Handler()
    private var Update: Runnable? = null
    private var imm: InputMethodManager? = null
    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room_detail)
        val intent = intent
        val roomId = intent.getStringExtra("room_id")
        val title = intent.getStringExtra("title")
        val position = intent.getIntExtra("position", 0)
        method = Method(this@RoomDetail)
        method!!.forceRTLIfSupported()
        progressDialog = ProgressDialog(this@RoomDetail)
        imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN)
        val toolbar = findViewById<MaterialToolbar>(R.id.toolbar_rd)
        toolbar.title = title
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)
        conMain = findViewById(R.id.con_rd)
        progressBar = findViewById(R.id.progressBar_rd)
        conNoData = findViewById(R.id.con_noDataFound)
        viewPager = findViewById(R.id.viewPager_rd)
        textViewRoomName = findViewById(R.id.textView_roomName_rd)
        textViewPrice = findViewById(R.id.textView_price_rd)
        textViewTotalRate = findViewById(R.id.textView_totalRating_rd)
        webViewDes = findViewById(R.id.webView_des_rd)
        webViewRules = findViewById(R.id.webView_rules_rd)
        ratingView = findViewById(R.id.ratingBar_rd)
        conRating = findViewById(R.id.con_rating_rd)
        recyclerViewRa = findViewById(R.id.recyclerView_roomAmenities_rd)
        cardViewBookNow = findViewById(R.id.cardView_bookNow_rd)
        imageViewRating = findViewById(R.id.imageView_rating_rd)
        textViewTotalRate!!.setTypeface(null)
        conMain!!.setVisibility(View.GONE)
        conNoData!!.setVisibility(View.GONE)
        recyclerViewRa!!.setHasFixedSize(true)
        val layoutManager_ra: RecyclerView.LayoutManager = LinearLayoutManager(this@RoomDetail)
        recyclerViewRa!!.setLayoutManager(layoutManager_ra)
        recyclerViewRa!!.setFocusable(false)
        val linearLayout = findViewById<LinearLayout>(R.id.linearLayout_rd)
        method!!.showBannerAd(linearLayout)
        if (method!!.isNetworkAvailable) {
            roomDetail(roomId)
        } else {
            progressBar!!.setVisibility(View.GONE)
            method!!.alertBox(resources.getString(R.string.internet_connection))
        }
    }

    fun roomDetail(room_id: String?) {
        progressBar!!.visibility = View.VISIBLE
        val jsObj = Gson().toJsonTree(API(this@RoomDetail)) as JsonObject
        jsObj.addProperty("room_id", room_id)
        jsObj.addProperty("method_name", "get_single_room")
        val apiService = ApiClient.getClient().create(ApiInterface::class.java)
        val call = apiService.getRoomDetail(API.toBase64(jsObj.toString()))
        call.enqueue(object : Callback<RoomDetailRP?> {
            @SuppressLint("SetTextI18n", "SetJavaScriptEnabled")
            override fun onResponse(call: Call<RoomDetailRP?>, response: Response<RoomDetailRP?>) {
                val statusCode = response.code()
                try {
                    val roomDetailRP = response.body()!!
                    if (roomDetailRP.status == "1") {
                        if (roomDetailRP.roomSliders.size != 0) {
                            val columnWidth = method!!.screenWidth
                            viewPager!!.layoutParams =
                                ConstraintLayout.LayoutParams(columnWidth, columnWidth / 2 + 80)
                            viewPager!!.useScale()
                            viewPager!!.removeAlpha()
                            sliderRoomDetailAdapter = SliderRoomDetailAdapter(
                                this@RoomDetail,
                                "room_detail_slider",
                                roomDetailRP.roomSliders
                            )
                            viewPager!!.adapter = sliderRoomDetailAdapter
                            Update = Runnable {
                                if (viewPager!!.currentItem == sliderRoomDetailAdapter!!.count - 1) {
                                    viewPager!!.setCurrentItem(0, true)
                                } else {
                                    viewPager!!.setCurrentItem(viewPager!!.currentItem + 1, true)
                                }
                            }
                            if (sliderRoomDetailAdapter!!.count > 1) {
                                timer = Timer() // This will create a new Thread
                                timer!!.schedule(object : TimerTask() {
                                    // task to be scheduled
                                    override fun run() {
                                        handler.post(Update!!)
                                    }
                                }, DELAY_MS, PERIOD_MS)
                            }
                        }
                        textViewRoomName!!.text = roomDetailRP.room_name
                        textViewPrice!!.text = roomDetailRP.room_price
                        ratingView!!.rating = roomDetailRP.rate_avg.toFloat()
                        textViewTotalRate!!.text = "(" + roomDetailRP.total_rate + ")"
                        val mimeType = "text/html"
                        val encoding = "utf-8"
                        webViewDes!!.setBackgroundColor(Color.TRANSPARENT)
                        webViewDes!!.isFocusableInTouchMode = false
                        webViewDes!!.isFocusable = false
                        webViewDes!!.settings.defaultTextEncodingName = "UTF-8"
                        webViewDes!!.settings.javaScriptEnabled = true
                        val textDes = ("<html dir=" + method!!.isWebViewTextRtl + "><head>"
                                + "<style type=\"text/css\">@font-face {font-family: MyFont;src: url(\"file:///android_asset/fonts/poppins_medium.ttf\")}body{font-family: MyFont;color: " + method!!.webViewText() + "line-height:1.6}"
                                + "a {color:" + method!!.webViewLink() + "text-decoration:none}"
                                + "</style></head>"
                                + "<body>"
                                + roomDetailRP.room_description
                                + "</body></html>")
                        webViewDes!!.loadDataWithBaseURL(null, textDes, mimeType, encoding, null)
                        webViewRules!!.setBackgroundColor(Color.TRANSPARENT)
                        webViewRules!!.isFocusableInTouchMode = false
                        webViewRules!!.isFocusable = false
                        webViewRules!!.settings.defaultTextEncodingName = "UTF-8"
                        webViewRules!!.settings.javaScriptEnabled = true
                        val textRules = ("<html dir=" + method!!.isWebViewTextRtl + "><head>"
                                + "<style type=\"text/css\">@font-face {font-family: MyFont;src: url(\"file:///android_asset/fonts/poppins_medium.ttf\")}body{font-family: MyFont;color: " + method!!.webViewText() + "line-height:1.6}"
                                + "a {color:" + method!!.webViewLink() + "text-decoration:none}"
                                + "</style></head>"
                                + "<body>"
                                + roomDetailRP.room_rules
                                + "</body></html>")
                        webViewRules!!.loadDataWithBaseURL(
                            null,
                            textRules,
                            mimeType,
                            encoding,
                            null
                        )
                        if (roomDetailRP.roomAmenitiesLists.size != 0) {
                            val roomAmenities = RoomAmenities(
                                this@RoomDetail,
                                "room_amenities",
                                roomDetailRP.roomAmenitiesLists
                            )
                            recyclerViewRa!!.adapter = roomAmenities
                        }
                        conMain!!.visibility = View.VISIBLE
                        conRating!!.setOnClickListener { v: View? ->
                            dialogReviewList(
                                roomDetailRP.id
                            )
                        }
                        imageViewRating!!.setOnClickListener { v: View? ->
                            dialogReview(
                                roomDetailRP.id
                            )
                        }
                        cardViewBookNow!!.setOnClickListener { v: View? ->
                            if (method!!.isLogin) {
                                startActivity(
                                    Intent(this@RoomDetail, BookRoom::class.java)
                                        .putExtra("id", roomDetailRP.id)
                                )
                            } else {
                                Method.loginBack = true
                                startActivity(Intent(this@RoomDetail, Login::class.java))
                            }
                        }
                    } else {
                        conNoData!!.visibility = View.VISIBLE
                        method!!.alertBox(roomDetailRP.message)
                    }
                } catch (e: Exception) {
                    Log.d("exception_error", e.toString())
                    method!!.alertBox(resources.getString(R.string.failed_try_again))
                }
                progressBar!!.visibility = View.GONE
            }

            override fun onFailure(call: Call<RoomDetailRP?>, t: Throwable) {
                // Log error here since request failed
                Log.e("error_fail", t.toString())
                conNoData!!.visibility = View.VISIBLE
                progressBar!!.visibility = View.GONE
                method!!.alertBox(resources.getString(R.string.failed_try_again))
            }
        })
    }

    private fun dialogReviewList(roomId: String) {
        progressDialog!!.show()
        progressDialog!!.setMessage(resources.getString(R.string.loading))
        progressDialog!!.setCancelable(false)
        val dialog = Dialog(this@RoomDetail)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.dialog_review_list)
        dialog.setCancelable(false)
        if (method!!.isRtl) {
            dialog.window!!.decorView.layoutDirection = View.LAYOUT_DIRECTION_RTL
        }
        dialog.window!!.setBackgroundDrawableResource(android.R.color.transparent)
        dialog.window!!.setLayout(
            ConstraintLayout.LayoutParams.MATCH_PARENT,
            ConstraintLayout.LayoutParams.WRAP_CONTENT
        )
        val imageViewClose = dialog.findViewById<ImageView>(R.id.imageView_dialog_review)
        val textViewTotalReview =
            dialog.findViewById<MaterialTextView>(R.id.textView_total_dialog_review)
        val recyclerView = dialog.findViewById<RecyclerView>(R.id.recyclerView_dialog_review)
        imageViewClose.setOnClickListener { v: View? -> dialog.dismiss() }
        recyclerView.setHasFixedSize(true)
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this@RoomDetail)
        recyclerView.layoutManager = layoutManager
        recyclerView.isFocusable = false
        val jsObj = Gson().toJsonTree(API(this@RoomDetail)) as JsonObject
        jsObj.addProperty("room_id", roomId)
        jsObj.addProperty("method_name", "get_rating")
        val apiService = ApiClient.getClient().create(ApiInterface::class.java)
        val call = apiService.getReview(API.toBase64(jsObj.toString()))
        call.enqueue(object : Callback<ReviewRP?> {
            @SuppressLint("SetTextI18n")
            override fun onResponse(call: Call<ReviewRP?>, response: Response<ReviewRP?>) {
                val statusCode = response.code()
                try {
                    val reviewRP = response.body()!!
                    if (reviewRP.status == "1") {
                        textViewTotalReview.typeface = null
                        textViewTotalReview.text = reviewRP.total_rate
                        if (reviewRP.reviewLists.size != 0) {
                            val reviewAdapter =
                                ReviewAdapter(this@RoomDetail, "review", reviewRP.reviewLists)
                            recyclerView.adapter = reviewAdapter
                            dialog.show()
                        } else {
                            method!!.alertBox(resources.getString(R.string.no_review_found))
                        }
                    } else {
                        method!!.alertBox(reviewRP.message)
                    }
                } catch (e: Exception) {
                    Log.d("exception_error", e.toString())
                    method!!.alertBox(resources.getString(R.string.failed_try_again))
                }
                progressDialog!!.dismiss()
            }

            override fun onFailure(call: Call<ReviewRP?>, t: Throwable) {
                // Log error here since request failed
                Log.e("error_fail", t.toString())
                progressDialog!!.dismiss()
                method!!.alertBox(resources.getString(R.string.failed_try_again))
            }
        })
    }

    private fun dialogReview(roomId: String) {
        progressDialog!!.show()
        progressDialog!!.setMessage(resources.getString(R.string.loading))
        progressDialog!!.setCancelable(false)
        val dialog = Dialog(this@RoomDetail)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.dialog_review)
        dialog.setCancelable(false)
        if (method!!.isRtl) {
            dialog.window!!.decorView.layoutDirection = View.LAYOUT_DIRECTION_RTL
        }
        dialog.window!!.setBackgroundDrawableResource(android.R.color.transparent)
        dialog.window!!.setLayout(
            ViewPager.LayoutParams.MATCH_PARENT,
            ViewPager.LayoutParams.WRAP_CONTENT
        )
        val imageViewClose = dialog.findViewById<ImageView>(R.id.imageView_dialog_rating)
        val ratingBar = dialog.findViewById<RatingView>(R.id.ratingBar_dialog_rating)
        val editText = dialog.findViewById<TextInputEditText>(R.id.editText_dialog_rating)
        val buttonSubmit = dialog.findViewById<MaterialButton>(R.id.button_dialog_rating)
        val jsObj = Gson().toJsonTree(API(this@RoomDetail)) as JsonObject
        jsObj.addProperty("room_id", roomId)
        jsObj.addProperty("user_id", method!!.userId())
        jsObj.addProperty("method_name", "get_user_rating")
        val apiService = ApiClient.getClient().create(ApiInterface::class.java)
        val call = apiService.getUserReview(API.toBase64(jsObj.toString()))
        call.enqueue(object : Callback<UserReviewRP?> {
            @SuppressLint("SetTextI18n")
            override fun onResponse(call: Call<UserReviewRP?>, response: Response<UserReviewRP?>) {
                val statusCode = response.code()
                try {
                    val userReviewRP = response.body()!!
                    if (userReviewRP.status == "1") {
                        if (userReviewRP.success == "1") {
                            ratingBar.rating = userReviewRP.user_rate.toFloat()
                            editText.setText(userReviewRP.user_msg)
                            dialog.show()
                        } else {
                            method!!.alertBox(userReviewRP.msg)
                        }
                    } else if (userReviewRP.status == "2") {
                        method!!.suspend(userReviewRP.message)
                    } else {
                        method!!.alertBox(userReviewRP.message)
                    }
                } catch (e: Exception) {
                    Log.d("exception_error", e.toString())
                    method!!.alertBox(resources.getString(R.string.failed_try_again))
                }
                progressDialog!!.dismiss()
            }

            override fun onFailure(call: Call<UserReviewRP?>, t: Throwable) {
                // Log error here since request failed
                Log.e("error_fail", t.toString())
                progressDialog!!.dismiss()
                method!!.alertBox(resources.getString(R.string.failed_try_again))
            }
        })
        imageViewClose.setOnClickListener { v: View? -> dialog.dismiss() }
        buttonSubmit.setOnClickListener { v: View? ->
            val message = editText.text.toString()
            editText.error = null
            if (message == "" || message.isEmpty()) {
                editText.requestFocus()
                editText.error = resources.getString(R.string.please_enter_review)
            } else if (ratingBar.rating == 0f) {
                method!!.alertBox(resources.getString(R.string.please_rate))
            } else {
                editText.clearFocus()
                imm!!.hideSoftInputFromWindow(editText.windowToken, 0)
                if (method!!.isNetworkAvailable) {
                    if (method!!.isLogin) {
                        submitRating(dialog, roomId, ratingBar.rating.toString(), message)
                    } else {
                        Method.loginBack = true
                        startActivity(Intent(this@RoomDetail, Login::class.java))
                    }
                } else {
                    method!!.alertBox(resources.getString(R.string.internet_connection))
                }
            }
        }
    }

    private fun submitRating(dialog: Dialog, roomId: String, rate: String, message: String) {
        progressDialog!!.show()
        progressDialog!!.setMessage(resources.getString(R.string.loading))
        progressDialog!!.setCancelable(false)
        val jsObj = Gson().toJsonTree(API(this@RoomDetail)) as JsonObject
        jsObj.addProperty("room_id", roomId)
        jsObj.addProperty("rate", rate)
        jsObj.addProperty("message", message)
        jsObj.addProperty("user_id", method!!.userId())
        jsObj.addProperty("method_name", "user_rating")
        val apiService = ApiClient.getClient().create(ApiInterface::class.java)
        val call = apiService.submitUserReview(API.toBase64(jsObj.toString()))
        call.enqueue(object : Callback<UserReviewSubmitRP?> {
            @SuppressLint("SetTextI18n")
            override fun onResponse(
                call: Call<UserReviewSubmitRP?>,
                response: Response<UserReviewSubmitRP?>
            ) {
                val statusCode = response.code()
                try {
                    val userReviewSubmitRP = response.body()!!
                    if (userReviewSubmitRP.status == "1") {
                        if (userReviewSubmitRP.success == "1") {
                            ratingView!!.rating = userReviewSubmitRP.rate_avg.toFloat()
                            textViewTotalRate!!.text = "(" + userReviewSubmitRP.total_rate + ")"
                            method!!.alertBox(userReviewSubmitRP.msg)
                            dialog.dismiss()
                        } else {
                            method!!.alertBox(userReviewSubmitRP.msg)
                        }
                    } else if (userReviewSubmitRP.status == "2") {
                        method!!.suspend(userReviewSubmitRP.message)
                    } else {
                        method!!.alertBox(userReviewSubmitRP.message)
                    }
                } catch (e: Exception) {
                    Log.d("exception_error", e.toString())
                    method!!.alertBox(resources.getString(R.string.failed_try_again))
                }
                progressDialog!!.dismiss()
            }

            override fun onFailure(call: Call<UserReviewSubmitRP?>, t: Throwable) {
                // Log error here since request failed
                Log.e("error_fail", t.toString())
                progressDialog!!.dismiss()
                method!!.alertBox(resources.getString(R.string.failed_try_again))
            }
        })
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}