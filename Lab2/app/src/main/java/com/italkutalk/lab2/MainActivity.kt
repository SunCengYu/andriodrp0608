package com.italkutalk.lab2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //宣告按鈕並從抓取相對物件
        val btn_mora: Button = findViewById<Button>(R.id.btn_mora)
        val btn_scissor: RadioButton = findViewById<RadioButton>(R.id.btn_scissor)
        val btn_stone: RadioButton = findViewById<RadioButton>(R.id.btn_stone)
        val btn_papper: RadioButton = findViewById<RadioButton>(R.id.btn_paper)
        //宣告文字並抓取相關物件
        val ed_name: EditText = findViewById<EditText>(R.id.ed_name)
        val tv_text: TextView = findViewById<TextView>(R.id.tv_text)
        val tv_name: TextView = findViewById<TextView>(R.id.tv_name)
        val tv_mmora: TextView = findViewById<TextView>(R.id.tv_mmora)
        val tv_cmora: TextView = findViewById<TextView>(R.id.tv_cmora)
        val tv_winner: TextView = findViewById<TextView>(R.id.tv_winner)
        //當按下按鈕執行程式
        btn_mora.setOnClickListener {
            //判斷字串是否空白要求輸入姓名
            if(ed_name.length()<1)
                tv_text.text = "請輸入玩家姓名"
            else {
                tv_name.text = "玩家\n${ed_name.text}"
                //選擇相對應的按鈕並顯示我方出拳
                tv_mmora.text = "我方出拳\n ${if (btn_scissor.isChecked) "剪刀"
                else if(btn_stone.isChecked) "石頭" else "布"}"
                //random()產生介於0~1之間的亂數不含1的亂數，乘3產生0~2當作電腦的出拳
                val computer = (Math.random()*3).toInt()
                //電腦亂數選擇，並顯示電腦出拳為何
                tv_cmora.text = "電腦出拳\n ${if (computer==0) "剪刀"
                else if(computer==1) "石頭" else "布"}"
                //用三個判斷式判斷並顯示猜拳結果
                when{
                    btn_scissor.isChecked && computer ==2 ||
                    btn_stone.isChecked && computer ==0 ||
                    btn_papper.isChecked && computer ==1 ->{
                        tv_winner.text = "winner is \n${ed_name.text}"
                        tv_text.text = "恭喜獲勝!!!"
                    }
                    btn_scissor.isChecked && computer ==1 ||
                            btn_stone.isChecked && computer ==2 ||
                            btn_papper.isChecked && computer ==0 ->{
                        tv_winner.text = "winner is \n電腦"
                        tv_text.text = "可惜殘念!!!"
                    }
                    else ->{
                        tv_winner.text = "平手"
                        tv_text.text = "請再試一次"
                    }
                }
            }
        }
    }
}