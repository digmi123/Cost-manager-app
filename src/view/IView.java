package view;

import viewmodel.IViewModel;

public interface IView {
    public void setViewModel(IViewModel viewModel);
    public void initLoginPage();
    public void startLoginPage();
}
