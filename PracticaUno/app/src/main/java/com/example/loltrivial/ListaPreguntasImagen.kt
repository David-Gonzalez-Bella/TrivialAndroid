package com.example.loltrivial

object ListaPreguntasImagen {
    fun getPreguntasImagen(): ArrayList<PreguntaImagen>{
        val lista = ArrayList<PreguntaImagen>();

        val preg1 = PreguntaImagen(
                1,
                "¿Cuál de estas es la region de Piltover?",
                R.drawable.ionia,
                R.drawable.noxus,
                R.drawable.piltover,
                R.drawable.targon,
                3
        )
//        val preg2 = PreguntaImagen(
//                1,
//                "¿Cuál de estos campeones no forma parte del grupo 'Pentakill'?",
//                "Karthus",
//                "Olaf",
//                "Mordekaiser",
//                "Katarina",
//                4
//        )
//        val preg3 = PreguntaImagen(
//                1,
//                "¿Cuáles son los apodos cariñosos con los que se refieren entre sí Xayah y Rakkan?",
//                "Mieli y miella",
//                "Melli y miala",
//                "Melia y mehali",
//                "Meeli y malli",
//                1
//        )
//        val preg4 = PreguntaImagen(
//                1,
//                "¿Cómo se llama la pistola de Jhin?",
//                "Bloom",
//                "Pum-pum",
//                "Trigger",
//                "Whisper",
//                4
//        )
//        val preg5 = PreguntaImagen(
//                1,
//                "¿Cómo se llama el tiburón de Fizz?",
//                "Teethy",
//                "Sharky",
//                "Chomper",
//                "Finn",
//                3
//        )
        lista.add(preg1);
//        lista.add(preg2);
//        lista.add(preg3);
//        lista.add(preg4);
//        lista.add(preg5);
        return lista;
    }
}