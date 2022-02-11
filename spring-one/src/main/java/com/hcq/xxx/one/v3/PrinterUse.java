package com.hcq.xxx.one.v3;


import lombok.Setter;

@Setter
public class PrinterUse implements printer {
    Paper paper;
    Cartridge cartridge;

    public PrinterUse() {
        paper = new Paper();
        cartridge = new Cartridge();
    }

    @Override
    public void print() {
        paper.show();
    }

    @Override
    public void price() {
        paper.price();
    }

    @Override
    public void name() {
        cartridge.color();
    }

    public final void printshow() {
        System.out.println("模板方法启动中");
        name();
        print();
        price();
        System.out.println("打印成功");
    }

}
