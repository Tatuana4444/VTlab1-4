package com.epam.shop.writer;

import com.epam.shop.entity.OnlineShop;
import com.epam.shop.exception.XmlDataException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;

/**
 * Class that save data to file
 */
public class XmlShopWriter {
    /**
     * Write data to file
     * @param shop online shop
     * @param fileName name of file
     * @throws XmlDataException if can't open file
     */
    public void write(OnlineShop shop, String fileName) throws XmlDataException {
        try {
            XmlMapper xmlMapper = new XmlMapper();
            xmlMapper.writeValue(new File(fileName), shop);
        } catch (IOException e) {
            throw new XmlDataException("can't open file Xml name = [" + fileName + "]", e);
        }
    }
}
