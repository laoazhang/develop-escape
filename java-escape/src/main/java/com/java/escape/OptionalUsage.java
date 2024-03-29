package com.java.escape;

import java.util.Optional;

/**
 * 学会Optional，规避空指针异常
 */
@SuppressWarnings("all")
public class OptionalUsage {

    public static class User{
        private String name;

        public String getName() {
            return name;
        }

        private static void isUserEqualNull(){

            User user = null;
            if (user != null){
                System.out.println("User is not null");
            }else {
                System.out.println("User is null");
            }

            Optional<User> optional = Optional.empty();
            if (optional.isPresent()){
                System.out.println("User is not null");
        }else {
                System.out.println("User is null");
            }
        }

        private static User anoymos(){
            return new User();
        }
        public static void main(String[] args) {
            // 没有意义的使用方法
            isUserEqualNull();

            User user = null;
            Optional<User> optionalUser = Optional.ofNullable(user);
            // 存在即返回，空则提空默认值
            optionalUser.orElse(new User());
            // 存在即返回，空由函数来产生
            optionalUser.orElseGet(() -> anoymos());
            // 存在即返回，否则抛出异常
            optionalUser.orElseThrow(RuntimeException::new);

            // 存在才去做相应的处理
            optionalUser.ifPresent(u -> System.out.println(u.getName()));

            // map 可以对 Optional 中的对象执行某种操作，且会返回一个 Optional 对象
            optionalUser.map(u -> u.getName()).orElse("anymos");

            // map 是可以无限级联操作的
            optionalUser.map(u -> u.getName()).map(name -> name.length()).orElse(0);
        }
    }
}
