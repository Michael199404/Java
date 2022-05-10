package com.chao.java8.optional;

/**
 * 使用 null 来表示变量的缺失是打错特错
 */
public class Person {

    private Car car;

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    // 可能出现空指针异常
//    public String getCarInsuranceName(Person person) {
//        return person.getCar().getInsurance().getName();
//    }

    // 防御式检查
    public String getCarInsuranceName(Person person) {
        if (null != person) {
            Car car = person.getCar();
            if (null != car) {
                Insurance insurance = car.getInsurance();
                if (null != insurance) {
                    return insurance.getName();
                }
            }
        }
        return "unknown";
    }

}
