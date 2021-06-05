package com.hianuy.santanderlayout.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hianuy.santanderlayout.data.Conta
import com.hianuy.santanderlayout.local.FakeData

// pegando os dados e está trafegando eles para nossa activity
// então
class MainViewModel: ViewModel() {
    // está definindo um liveData mutável
    // tem a responsabilidade de está setando um valor
    // setar um dado que vai ser observado
    // existe dois tipos o liveData que so repassa dados basicamente
    // e o MutableLiveData vc consegue mudar alguma informação do liveData


    // assim vamos desacoplar os nossos dados da camada de activity
    // vao ser observados no futuro
    private val mutableLiveData: MutableLiveData<Conta> = MutableLiveData()

    fun buscarContaCliente(): LiveData<Conta>{
        mutableLiveData.value = FakeData().getLocalData()
        return mutableLiveData
    }


}