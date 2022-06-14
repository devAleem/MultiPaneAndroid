package com.aleem.multipane

class ItemAddedList(val itemName:String, val itemQuantity:Int,val itemPrice:Int) {
    val itemTotalPrice:Int
    get() = this.itemQuantity * this.itemPrice

}