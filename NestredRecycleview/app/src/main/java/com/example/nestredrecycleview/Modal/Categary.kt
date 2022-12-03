package com.example.nestredrecycleview.Modal

//darek parent ma ak tital ,id and list has
//parent class
data class Categary(
    var id:Int,
    var Tital:String,
    //sub class nu list pas karelu
    var Movielist:MutableList<SubCategary>
)
