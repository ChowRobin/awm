package pers.robin.awm.bean;

public enum OrderStatus {

    INIT(0),
    WAITING_FOR_PAY(1),
    INTERNAL_ERROR(41),
    PAID(3),
    CANCELED_BY_CUSTOMER(42),
    CANCELED_BY_ADMIN(43),
    PAY_TIMEOUT(44),
    COMPLETED(20);

    private int index;

    OrderStatus(int index) {
        this.index = index;
    }

}
