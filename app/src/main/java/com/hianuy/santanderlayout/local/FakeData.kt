package com.hianuy.santanderlayout.local

import com.hianuy.santanderlayout.data.Cartao
import com.hianuy.santanderlayout.data.Cliente
import com.hianuy.santanderlayout.data.Conta

class FakeData() {
    // pegando os nosso dataClass e está fornecendo um mecanismo
    // com esses dados já estruturados e preenchidos para pordemos trafegar
    // a nossa view
    fun getLocalData(): Conta {
        val cliente = Cliente("Hianuy")
        val cartao = Cartao("4111111")

        return Conta(
            "03040689-0",
            "2211",
            "9450",
            "1320",
            cliente,
            //2450,00"
            cartao
        )

    }
}