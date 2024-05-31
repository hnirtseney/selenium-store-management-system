package pos.form.expenses;

public class CreateExpenseForm {
    public String expenseCategory;
    public String expenseTotalAmount;

    public CreateExpenseForm(String expenseCategory, String expenseTotalAmount) {
        this.expenseCategory = expenseCategory;
        this.expenseTotalAmount = expenseTotalAmount;
    }
}

