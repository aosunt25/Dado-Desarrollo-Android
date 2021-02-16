package edu.itesm.dado

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    var total_tiros = 0
    var num_tiro = 1
    var puntos_p1 = 0
    var puntos_p2 = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //test_kotlin()
        mensaje.text = "Bienvenidos"
        roll_dice.text = "Jugador 1"
        tira_dado()
    }

    fun tira_dado(){

        roll_dice.setOnClickListener {
            if (num_tiro < 7 && num_tiro%2 !=0){
                roll_dice.text = "Jugador 2"
                val rand = Random.nextInt(1, 6)
                mensaje.text = "$rand "
                puntos_p1+=rand
                num_tiro++
            }
            else if (num_tiro < 7 && num_tiro%2 ==0){
                roll_dice.text = "Jugador 1"
                val rand = Random.nextInt(1, 6)
                mensaje.text = "$rand "
                puntos_p2+=rand
                num_tiro++
            }
            else if (num_tiro == 7){
                val ganador = if(puntos_p1 > puntos_p2){
                    "Jugador 1 es el Ganador"
                }
                else if (puntos_p1 < puntos_p2){
                    "Jugador 2 es el Ganador"
                }
                else{
                    "Empate"
                }
                mensaje.text = ganador
                roll_dice.text = "Reiniciar"
                num_tiro++
            }
            else{
                    mensaje.text = "Bienvenidos"
                    total_tiros = 0
                    num_tiro = 1
                    puntos_p1 = 0
                    puntos_p2 = 0
                    roll_dice.text = "Jugador 1"
            }
        }


        }

    }
    /*
    fun test_kotlin(){
        val edad = 45
        val peso :Double = 67.7
        val altura: Float = 1.58F

        Log.i("edu.itesm.dado", imc(peso, altura))
    }
    fun imc (peso: Double, altura: Float):String{
        val imc_num = peso/ (altura * altura)
        val imc_str = if (imc_num > 18.5 && imc_num < 25){
            "$imc_num normal"
        }
        else if (imc_num > 25 && imc_num < 30){
            "$imc_num sobrepeso"
        }
        else {
            "$imc_num obesidad"
        }
        return imc_str
    }

     */
