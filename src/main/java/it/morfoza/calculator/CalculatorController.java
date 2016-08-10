package it.morfoza.calculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {

    private Calculator calculator;

    @Autowired
    public CalculatorController(Calculator calculator) {
        this.calculator = calculator;
    }

    @RequestMapping("/")
    public String calculatorForm() {
        return "calculator_form";
    }

    @RequestMapping("/calculate")
    public String calculate(@RequestParam("operation") String operation,
                            @RequestParam("number1") long number1,
                            @RequestParam("number2") long number2,
                            Model model)
    {
        long result;
        if (operation.equals("+")) {
            result = calculator.add(number1, number2);
        } else if (operation.equals("-")) {
            result = calculator.subtract(number1, number2);
        } else if (operation.equals("*")) {
            result = calculator.multiply(number1, number2);
        } else if (operation.equals("/")) {
            result = calculator.divide(number1, number2);
        } else {
            throw new RuntimeException("Operation not supported: " + operation);
        }
        model.addAttribute("result", result);
        return "calculator_result";
    }
}
