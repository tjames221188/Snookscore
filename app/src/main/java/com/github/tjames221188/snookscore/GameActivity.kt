package com.github.tjames221188.snookscore

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_game.*

class GameActivity : AppCompatActivity() {

    //Member variables for holding the score
    private var mScore1: Int = 0
    private var mScore2: Int = 0

    //Member variable for the two score TextView
    //private var mScoreText1: TextView? = null
    //private var mScoreText2: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        //Inflate the layout
        setContentView(R.layout.activity_game)

        //Restores the scores if there is savedInstanceState
        if (savedInstanceState != null) {
            mScore1 = savedInstanceState.getInt(STATE_SCORE_1)
            mScore2 = savedInstanceState.getInt(STATE_SCORE_2)

            //Set the score text views
            score_1.text = mScore1.toString()
            score_2.text = mScore2.toString()
        }
    }

    fun potBall(view: View) {
        val viewID = view.id
        when (viewID) {
            R.id.pot_red    -> mScore1 += 1
            R.id.pot_yellow -> mScore1 += 2
            R.id.pot_green  -> mScore1 += 3
            R.id.pot_brown  -> mScore1 += 4
            R.id.pot_blue   -> mScore1 += 5
            R.id.pot_pink   -> mScore1 += 6
            R.id.pot_black  -> mScore1 += 7
        }

        score_1.text = mScore1.toString()
    }

    /**
     * Method that is called when the configuration changes, used to preserve the state of the app
     * @param outState The bundle that will be passed in to the Activity when it is restored
     */
    override fun onSaveInstanceState(outState: Bundle?) {
        //Save the scores
        outState!!.putInt(STATE_SCORE_1, mScore1)
        outState.putInt(STATE_SCORE_2, mScore2)
        super.onSaveInstanceState(outState)
    }

    companion object {

        //Tag to be used as the key in OnSavedInstanceState
        internal val STATE_SCORE_1 = "Team 1 Score"
        internal val STATE_SCORE_2 = "Team 2 Score"
    }
}
