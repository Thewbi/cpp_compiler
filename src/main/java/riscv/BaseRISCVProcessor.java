package riscv;

import org.apache.commons.lang3.StringUtils;

import common.IMemory;
import common.IRegisterFile;
import common.IntegerParserUtil;
import javafx.beans.InvalidationListener;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.property.StringPropertyBase;
import javafx.beans.property.adapter.JavaBeanStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public abstract class BaseRISCVProcessor {

    // private StringProperty x1StringProperty = new SimpleStringProperty();
    // private StringProperty s0StringProperty = new SimpleStringProperty();

    // /**
    //  * 
    //  */
    // public BaseRISCVProcessor() {
    //     x1StringProperty.addListener(new ChangeListener<String>() {

    //         @Override
    //         public void changed(ObservableValue<? extends String> observableValue, String oldValue, String newValue) {
    //             System.out.println("observableValue: " + observableValue + " oldValue: " + oldValue + " newValue: " + newValue);

    //             registerFile[RISCVRegister.mapRegister("x1")] = IntegerParserUtil.parseInt(newValue);
    //         }
            
    //     });
    // }

    protected IMemory memory;

    protected IRegisterFile registerFile;

    protected int idx = 0;

    // public Property getTextProperty(String registerName) {
        
    //     if (StringUtils.equalsIgnoreCase(registerName, "x1")) {
    //         return x1StringProperty;
    //     }
    //     if (StringUtils.equalsIgnoreCase(registerName, "s0")) {
    //         return s0StringProperty;
    //     }
    //     throw new UnsupportedOperationException("Unimplemented method 'getTextProperty'");
    // }

    public IMemory getMemory() {
        return memory;
    }

    public void setMemory(IMemory memory) {
        this.memory = memory;
    }

    public void setRegisterFile(DefaultRegisterFile registerFile) {
        this.registerFile = registerFile;
    }
    
}
