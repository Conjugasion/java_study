package DesignMode.StrategyMode;

/**
 * @author Lucas
 * @date 2019/7/29 15:55
 */
public class StrategyDemo {
    public static void main(String[] args) {
        StrategyDemo demo = new StrategyDemo();
        Strategy strategy = demo.new AddStrategy();
        Context context = demo.new Context(strategy);
        context.exectute(1,2);
    }

    // 总策略
    interface Strategy{
        void exectute(int a, int b);
    }

    class AddStrategy implements Strategy{

        @Override
        public void exectute(int a, int b) {
            System.out.println("AddStrategy: " + (a+b));
        }
    }
    class SubStrategy implements Strategy{

        @Override
        public void exectute(int a, int b) {
            System.out.println("SubStrategy: " + (a-b));
        }
    }
    class MultiStrategy implements Strategy{

        @Override
        public void exectute(int a, int b) {
            System.out.println("MultiStrategy: " + (a*b));
        }
    }
    class DivStrategy implements Strategy{

        @Override
        public void exectute(int a, int b) {
            System.out.println("DivStrategy: " + (a/b));
        }
    }

    // 上下文语境
    class Context{
        private Strategy strategy;
        public Context(Strategy strategy){
            this.strategy = strategy;
        }
        void exectute(int a, int b){
            strategy.exectute(a, b);
        }
    }
}
