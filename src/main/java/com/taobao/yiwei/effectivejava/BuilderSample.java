package com.taobao.yiwei.effectivejava;

public class BuilderSample {
    public static void main(String[] args) {
        NutritionFacts nutritionFacts = new NutritionFacts.Builder(240, 8)
                .calories(100).sodium(35).carbohydrate(27).build();
        System.out.println(nutritionFacts);
    }
}


class NutritionFacts {

    private final int servingSize;
    private final int servings;
    private final int calories;
    private final int fat;
    private final int sodium;
    private final int carbohydrate;

    public static class Builder {
        // Required arguments
        private final int servingSize;
        private final int servings;

        // Optional arguments
        private int calories;
        private int fat;
        private int sodium;
        private int carbohydrate;

        public Builder(int servingSize, int servings) {
            this.servingSize = servingSize;
            this.servings = servings;
        }

        public Builder calories(int val) {
            this.calories = val;
            return this;
        }
        public Builder fat(int val) {
            this.fat = val;
            return this;
        }
        public Builder sodium(int val) {
            this.sodium = val;
            return this;
        }
        public Builder carbohydrate(int val) {
            this.carbohydrate = val;
            return this;
        }

        public NutritionFacts build() {
            return new NutritionFacts(this);
        }
    }

    private NutritionFacts(Builder builder) {
        servingSize = builder.servingSize;
        servings = builder.servings;
        calories = builder.calories;
        fat = builder.fat;
        sodium = builder.sodium;
        carbohydrate = builder.carbohydrate;
    }

    @Override
    public String toString() {
        return "servingSize:" + servingSize + "\n"
                + "servings:" + servings + "\n"
                + "calories:" + calories + "\n"
                + "fat:" + fat + "\n"
                + "sodium:" + sodium + "\n"
                + "carbohydrate:" + carbohydrate + "\n";

    }
}
