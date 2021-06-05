package com.hianuy.santanderlayout.ui

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.AutoTransition
import android.transition.TransitionManager
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.hianuy.santanderlayout.R

class MainActivity : AppCompatActivity() {

    private lateinit var txtNome: TextView
    private lateinit var txtAgencia: TextView
    private lateinit var txtContaCorrente: TextView
    private lateinit var txtSaldoDisponivel: TextView
    private lateinit var txtSaldo: TextView
    private lateinit var txtSaldoMoreLimit: TextView
    private lateinit var txtCartaoValue: TextView
    private lateinit var imgExpansable: ImageView
    private lateinit var constraint: ConstraintLayout
    private lateinit var imgExpansableCreditCard: ImageView
    private lateinit var constraintCreditCard: ConstraintLayout
    private lateinit var constraintImgExpansable: ConstraintLayout
    private lateinit var constraintImgExpansableCreditCard: ConstraintLayout
    private lateinit var constraintPoupança: ConstraintLayout
    private lateinit var constraintImgExpansablePoupança: ConstraintLayout
    private lateinit var constraintImgExpansableEmprestimo: ConstraintLayout
    private lateinit var constraintEmprestimo: ConstraintLayout
    private lateinit var imgExpansablePoupanca: ImageView
    private lateinit var imgExpansableEmprestimo: ImageView
    private lateinit var  constraintInvestimento: ConstraintLayout
    private lateinit var constraintImgExpansableInvestimento: ConstraintLayout
    private lateinit var imgExpansableInvestimento: ImageView
    // estamos dizendo que ele vai ser construindo posteriormente
    // precisamos construir ele no onCreate
    private lateinit var mainViewModel: MainViewModel

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        linkingXmlComponents()
        constraint.visibility = View.VISIBLE
        // precisamos definir sempre que nossa activity for criada para que
        // ele mostre nossa toolbar
        // findViewById com ele podemos está recuperando um componente
        // usado também para qualquer tipo de componente
        setSupportActionBar(findViewById(R.id.toolbar))
        // já estamos construindo aqui o nosso viewModel

        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        buscarContaCorrente()
        constraintImgExpansable.setOnClickListener {
            if (constraint.visibility == View.VISIBLE) {
                TransitionManager.beginDelayedTransition(
                    constraint as ViewGroup,
                    AutoTransition()
                )
                constraint.visibility = View.GONE
                imgExpansable.animate().rotation(180f).start()
            } else {
                TransitionManager.beginDelayedTransition(
                    constraint as ViewGroup,
                    AutoTransition()
                )
                constraint.visibility = View.VISIBLE
                imgExpansable.animate().rotation(0f).start()

            }

        }

        constraintImgExpansableCreditCard.setOnClickListener {
            if (constraintCreditCard.visibility == View.VISIBLE) {
                TransitionManager.beginDelayedTransition(
                    constraintCreditCard as ViewGroup,
                    AutoTransition()
                )
                constraintCreditCard.visibility = View.GONE
                imgExpansableCreditCard.animate().rotation(0f).start()
            } else {
                constraintCreditCard.visibility = View.VISIBLE
                imgExpansableCreditCard.animate().rotation(180f).start()

                TransitionManager.beginDelayedTransition(
                    constraintCreditCard as ViewGroup,
                    AutoTransition()
                )

            }
        }
        constraintImgExpansablePoupança.setOnClickListener {
            if (constraintPoupança.visibility == View.VISIBLE) {
                TransitionManager.beginDelayedTransition(
                    constraintPoupança as ViewGroup,
                    AutoTransition()
                )
                imgExpansablePoupanca.animate().rotation(0f).start()
                constraintPoupança.visibility = View.GONE


            } else {
                TransitionManager.beginDelayedTransition(
                    constraintPoupança as ViewGroup,
                    AutoTransition()
                )
                constraintPoupança.visibility = View.VISIBLE
                imgExpansablePoupanca.animate().rotation(180f).start()

            }
        }

        constraintImgExpansableEmprestimo.setOnClickListener {

            if (constraintEmprestimo.visibility == View.VISIBLE) {
                TransitionManager.beginDelayedTransition(
                    constraintEmprestimo as ViewGroup,
                    AutoTransition()
                )
                imgExpansableEmprestimo.animate().rotation(0f).start()
                constraintEmprestimo.visibility = View.GONE
            } else if (constraintEmprestimo.visibility == View.GONE) {
                TransitionManager.beginDelayedTransition(
                    constraintEmprestimo as ViewGroup,
                    AutoTransition()
                )
                imgExpansableEmprestimo.animate().rotation(180f).start()
                constraintEmprestimo.visibility = View.VISIBLE

            }
        }

        constraintImgExpansableInvestimento.setOnClickListener {
            if (constraintInvestimento.visibility == View.VISIBLE) {
                TransitionManager.beginDelayedTransition(
                    constraintEmprestimo as ViewGroup,
                    AutoTransition()
                )
                imgExpansableInvestimento.animate().rotation(0f).start()
                constraintInvestimento.visibility = View.GONE
            } else if (constraintInvestimento.visibility == View.GONE) {
                TransitionManager.beginDelayedTransition(
                    constraintInvestimento as ViewGroup,
                    AutoTransition()
                )
                imgExpansableInvestimento.animate().rotation(180f).start()
                constraintInvestimento.visibility = View.VISIBLE

            }
        }
    }

    @SuppressLint("SetTextI18n")
    private fun buscarContaCorrente() {
        mainViewModel.buscarContaCliente().observe(this, Observer {
            // it vai ser nossa conta aqui
            Log.i("Agencia", "onCreate: " + it.agencia)
            txtAgencia.text ="Ag ${it.agencia}"
            txtNome.text = "Olá, ${it.cliente.nome}"
            txtContaCorrente.text ="Cc ${it.numero}"
//            txtSaldo.text = "R$ ${it.saldo},00"
            txtSaldo.text = "R$ 10.280,44"

//            val saldoMaisLimite = it.saldo.toInt() + it.limite.toInt()

//            txtSaldoMoreLimit.text = "R$ ${saldoMaisLimite},00"
            txtSaldoMoreLimit.text = "R$ 12,888,22"
//            txtCartaoValue.text = it.cartao.numeroConta
        })

    }

    private fun linkingXmlComponents() {
        txtAgencia =
            findViewById(R.id.txt_agency)
        txtNome =
            findViewById(R.id.txt_user)
        txtContaCorrente =
            findViewById(R.id.txt_current_account)
        txtSaldo =
            findViewById(R.id.txt_balance)
        txtSaldoDisponivel =
            findViewById(R.id.txt_balance_available)
        txtSaldoMoreLimit =
            findViewById(R.id.txt_balance_more_limit)
        imgExpansable =
            findViewById(R.id.img_expansable_account)
        constraint =
            findViewById(R.id.constraint_more_details_account)
        imgExpansableCreditCard =
            findViewById(R.id.img_expansable_credit_card)
        constraintCreditCard =
            findViewById(R.id.constraint_more_information_credit_card)
        constraintImgExpansable =
            findViewById(R.id.constraint_img_expansable_more_details_account)
        constraintImgExpansableCreditCard =
            findViewById(R.id.constraint_img_expansable_credit_card)
        constraintPoupança = findViewById(R.id.constraint_savings_more_information)
        constraintImgExpansablePoupança =
            findViewById(R.id.constraint_img_expansable_savings)
        imgExpansablePoupanca =
            findViewById(R.id.img_expansable_savings)
        constraintImgExpansableEmprestimo =
            findViewById(R.id.constraint_img_expansable_more_information_lending)
        constraintEmprestimo =
            findViewById(R.id.constraint_lending_more_information)
        imgExpansableEmprestimo =
            findViewById(R.id.img_expansable_lending)
        constraintInvestimento =
            findViewById(R.id.constraint_investments_more_information)
        constraintImgExpansableInvestimento =
            findViewById(R.id.constraint_img_expansable_investments)
        imgExpansableInvestimento =
            findViewById(R.id.img_expansable_investments)
    }

    // é um metodo que já existe na AppCompatActivity
    // vamos está sobrescrevendo ela
    // por isso se tem um override
    // estamos herdando tudo o comportamento de menu
    //
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val menuInflater = menuInflater
        // resources
        // olhar pro lado esquerdo onde se tem o organizaçao
        // do projeto

        menuInflater.inflate(R.menu.menu_main, menu)
        // precisamos que esse menu sempre seja exibido
        return true
    }

    // ele vai escutar pra nois o item do menu
    // por exemplo se o item do meu menu de id 1 for clicado faça alguma ação

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when (item.itemId) {
            R.id.item_1 -> {
                Log.d("Clicado", "onOptionsItemSelected: " + "item1FoiClicado")
                return true

            }
            else -> super.onOptionsItemSelected(item)
// ele mesmo
        }
    }
}