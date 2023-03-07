package gauss;

public class Algorithm<N extends Number, T extends Gauss<N, T>> {
    LinearSystem<N, T> list;

    public Algorithm(LinearSystem<N, T> system) {
        list = system;
    }

    public void calculate() throws NullPointerException, ArithmeticException {
        if (list == null) {
            throw new NullPointerException("LinearSystem instance is null");
        }
        if (!checkSystem(list)) {
            throw new ArithmeticException("Incorrect system for Gauss Method");
        }

        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                N k = list.get(j).findCoefficient(list.get(j).at(i), list.get(i).at(i));
                list.get(j).mul(k);
                list.get(j).addEquation(list.get(i));
            }
        }
    }
//
//    public void calculateDeterminant() {
//        N det = null;
//        for (int i = 0; i < list.size(); i++) {
//            if (det == null) {
//                det = list.get(i).at(i);
//            } else {
//                det *= list.get(i).at(i);
//            }
//        }
//    }

    private boolean checkSystem(LinearSystem<N, T> system) {
        if (system.size() < 2) return false;
        for (int i = 0; i < system.size(); i++) {
            if (system.get(i).size() != (system.size() + 1)) {
                return false;
            }
        }
        return true;
    }
}