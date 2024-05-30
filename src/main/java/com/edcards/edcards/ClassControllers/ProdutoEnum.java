package com.edcards.edcards.ClassControllers;


import com.edcards.edcards.Programa.Classes.Produto;

public enum ProdutoEnum {
        REFEICOES,
        TAXA,
        FOTOCOPIAS,
        DOCES,
        SALGADOS,
        BEBIDAS,
        FOLHASTESTE,
        SANDES,
        PAPELARIA,
        BAGUETES,
        BOLOS,
        CAFETARIA;
        public int toDbValue() {return this.ordinal();}
        public static ProdutoEnum fromDbValue(int value) {
            return ProdutoEnum.values()[value];
        }

        public static String[] getStringValues() {
            ProdutoEnum[] values = ProdutoEnum.values();
            String[] stringValues = new String[values.length];
            for (int i = 0; i < values.length; i++) {
                stringValues[i] = values[i].toString();
            }
            return stringValues;
        }

    }



