package edu.dp;

public class Main {

    public static void main(String[] args) {
        IMediator<AbstractDialog> listSelectionMediator = new ListSelectionListener();
        IObserver listSelectionObserver = (IObserver) listSelectionMediator;

        // create subjects - components with mediators
        ButtonDialog buttonDialog = new ButtonDialog(listSelectionMediator);
        ListDialog listDialog = new ListDialog(listSelectionMediator);

        // register mediator colleagues
        listSelectionMediator.register(buttonDialog);
        listSelectionMediator.register(listDialog);

        // register observers for both subjects
        buttonDialog.register(listSelectionObserver);
        listDialog.register(listSelectionObserver);


    }
}
