package com.example.nutempu.model

import com.google.gson.annotations.SerializedName

data class Code (

    @SerializedName("objetos"    ) var objetos    : List<Objetos> = listOf(),

    )


data class Objetos (

    @SerializedName("codObjeto"                  ) var codObjeto                  : String?            = null,
    @SerializedName("eventos"                    ) var eventos                    : List<Eventos> = listOf(),

)


data class Eventos (

    @SerializedName("codigo"     ) var codigo     : String?  = null,
    @SerializedName("descricao"  ) var descricao  : String?  = null,
    @SerializedName("unidade"    ) var unidade    : Unidade? = Unidade(),

)



data class Unidade (

    @SerializedName("endereco" ) var endereco : Endereco? = Endereco(),

)



data class Endereco (

    @SerializedName("cidade" ) var cidade : String? = null,

)