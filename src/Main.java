import model.IModel;
import model.SimpleCostManagerModel;
import view.IView;
import view.SimpleCostManagerView;
import viewmodel.IViewModel;
import viewmodel.SimpleViewModel;

import javax.swing.*;

public class Main {
    public static void main(String args[]){

        IModel model = new SimpleCostManagerModel();
        IViewModel vm = new SimpleViewModel();
        IView view = new SimpleCostManagerView();

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                view.initLoginPage();
                view.startLoginPage();
            }
        });

        model.setViewModel(vm);
        vm.setModel(model);
        vm.setView(view);
        view.setViewModel(vm);
    }
}
