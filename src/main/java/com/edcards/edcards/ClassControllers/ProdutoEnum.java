package com.edcards.edcards.ClassControllers;


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

        

    }



