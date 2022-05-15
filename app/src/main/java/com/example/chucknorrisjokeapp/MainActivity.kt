package com.example.chucknorrisjokeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var newRecyclerview : RecyclerView
    private lateinit var newArrayList : ArrayList<Items>
    lateinit var imageId : Array<Int>
    lateinit var joke : Array<String>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageId = arrayOf(
            R.drawable.chuck_2jpg,
            R.drawable.chuck_2jpg,
            R.drawable.chuck_2jpg,
            R.drawable.chuck_2jpg,
            R.drawable.chuck_2jpg,
            R.drawable.chuck_2jpg,
            R.drawable.chuck_2jpg,
            R.drawable.chuck_2jpg,
            R.drawable.chuck_2jpg,
            R.drawable.chuck_2jpg
        )

        joke = arrayOf(
            "Chuck Norris does not need a reason to kill. but he needs a good one to stop...... no such reason has been thought of yet",
            "Little-known fact: Chuck Norris murdered Heath Ledger when he refused to give up an Olsen twin.",
            "Chuck Norris doesn't chew gum. Chuck Norris chews tin foil.",
            "Chuck Norris doesn't avail for a broadband promo. he reaches out through the satellite in space.",
            "Chuck Norris knows where your car is - in his stomach.",
            "When Chuck Norris goes ten-pin bowling, he simply throws the ball straight at the pins, shattering them. He hasn't achieved a perfect game yet, as the building usually collapses before then.",
            "Chuck Norris built a time machine and went back in time to stop the JFK assassination. As Oswald shot, Chuck met all three bullets with his beard, deflecting them. JFK's head exploded out of sheer amazement.",
            "Chuck Norris can tgjiethgrvljhjdhntsrndkhjdkhkfghbjrdsnhwedjkwbnjdfss HAAAAAAAAAAAAAAAAAACK! STOP! PLEASE! I BEG UH He died. I knew what he was going to say. It's super secret. if anyone knows, they die. Oh, and he was using this software called \"Dragon\": it's a speech-to-text device. - Chuck Norris",
            "Chuck Norris isn't really a Texas Ranger, although mentioning such blasphamy in a bar setting will undoubtably start a riot. I highly recomend trying it out if you have balls 1/8th the size of Chuck's.",
            "Chuck Norris can crush a polar bear's neck with his biceps."
        )

        newRecyclerview = findViewById(R.id.recyclerview)
        newRecyclerview.layoutManager = LinearLayoutManager(this)
        newRecyclerview.setHasFixedSize(true)

        newArrayList = arrayListOf<Items>()
        fillingData()
    }

    private fun fillingData(){

        for (i in imageId.indices){
            val items = Items(imageId[i], joke[i])
            newArrayList.add(items)
        }

        newRecyclerview.adapter = JokeAdapter(newArrayList)

    }

}
