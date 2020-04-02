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

        // test different cases
        buttonDialog.clickAddNew("Test 1");
        buttonDialog.clickAddNew("Test 2");
        buttonDialog.clickAddNew("Test 3");

        listDialog.selectItem(2);
        listDialog.selectItem(0);
        listDialog.deselectItem(0);
        listDialog.deselectItem(2);

        buttonDialog.clickAddNew("Test 4");
        listDialog.selectItem(3);
        buttonDialog.clickUpdateSelected("Update test 4");

    }
}
