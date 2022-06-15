package com.aleem.multipane

class ItemAddedList(val itemName:String, val itemQuantity:String,val itemPrice:String) {
    val itemTotalPrice:Int
    get() = this.itemQuantity.toInt() * this.itemPrice.toInt()

}