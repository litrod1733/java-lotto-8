package lotto;

import lotto.controller.LottoController;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            new LottoController().run();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}

