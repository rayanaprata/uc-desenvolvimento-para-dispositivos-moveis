package com.ifsc.travelapp;

import java.util.HashMap;
import java.math.BigDecimal;

public class DestinoController{
    public Destino[] DESTINOS = {BLUMENAU, CURITIBA, FLORIANOPOLIS, GRAMADO, RIODEJANEIRO, SALVADOR, SAOPAULO, TIMBO};
    public HashMap<String, Destino>  DESTINO_MAP =new HashMap<>();

    public DestinoController() {
        for (Destino destino : DESTINOS) {
            DESTINO_MAP.put(String.valueOf(destino.getCodigo()), destino);
        }
    }

    public static final Destino BLUMENAU = new Destino("Blumenau", "Cidade da Oktoberfest.", R.drawable.blumenau, new BigDecimal(210.99), new BigDecimal(300.0), 435, new BigDecimal(4.3), 101010);
    public static final Destino CURITIBA = new Destino("Curitiba", "Conhecida como centro cultural é a capital do estado do Paraná.", R.drawable.curitiba, new BigDecimal(450.0), new BigDecimal(500.50), 2922, new BigDecimal(4.8), 111111);
    public static final Destino FLORIANOPOLIS = new Destino("Florianópolis", "Famosa pelas suas praias, incluindo estâncias turísticas populares como a Praia dos Ingleses na extremidade norte da ilha.", R.drawable.florianopolis, new BigDecimal(385.9), new BigDecimal(586.5), 6578, new BigDecimal(4.7), 121212);
    public static final Destino GRAMADO = new Destino("Gramado", "Influenciada pelos colonos alemães do século XIX, a cidade possui um toque bávaro com chalés alpinos, chocolateiros e lojas de artesanato." , R.drawable.gramado, new BigDecimal(489.9), new BigDecimal(650.50), 7589, new BigDecimal(5.0), 131313);
    public static final Destino RIODEJANEIRO = new Destino("Rio de Janeiro", "O Rio de Janeiro é uma grande cidade brasileira à beira-mar, famosa pelas praias de Copacabana e Ipanema, pela estátua de 38 metros de altura do Cristo Redentor, no topo do Corcovado, e pelo Pão de Açúcar, um pico de granito com teleféricos até seu cume." , R.drawable.riodejaneiro, new BigDecimal(585.9), new BigDecimal(690.50), 6899, new BigDecimal(4.2), 141414);
    public static final Destino SALVADOR = new Destino("Salvador", "Salvador, a capital do estado da Bahia no nordeste do Brasil, é conhecida pela arquitetura colonial portuguesa, pela cultura afrobrasileira e pelo litoral tropical." , R.drawable.salvador, new BigDecimal(489.9), new BigDecimal(670.50), 4650, new BigDecimal(4.6), 151515);
    public static final Destino SAOPAULO = new Destino("São Paulo", "Município brasileiro, capital do estado homônimo e principal centro financeiro, corporativo e mercantil da América do Sul." , R.drawable.saopaulo, new BigDecimal(658.9), new BigDecimal(850.50), 8750, new BigDecimal(4.4), 161616);
    public static final Destino TIMBO = new Destino("Timbó", "Timbó é um município brasileiro do estado de Santa Catarina, também conhecido como a Pérola do Vale." , R.drawable.timbo, new BigDecimal(98.9), new BigDecimal(150.50), 240, new BigDecimal(4.8), 171717);
};
