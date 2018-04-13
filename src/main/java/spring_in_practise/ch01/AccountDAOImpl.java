package spring_in_practise.ch01;

import org.springframework.core.io.Resource;

import java.io.BufferedReader;
import java.io.FileReader;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class AccountDAOImpl implements AccountDAO {
    private Resource csvResource;

    public void setCsvResource(Resource csvFile) {
        this.csvResource = csvFile;
    }

    public Resource getCsvResource() {
        return csvResource;
    }


    @Override
    public List<Account> findAll() throws Exception {
        ArrayList<Account> results = new ArrayList<Account>();
        DateFormat dataFormat = new SimpleDateFormat("MMddyyyy");

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(csvResource.getFile()))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] fields = line.split(",");
                results.add(new Account(fields[0], new BigDecimal(fields[1]), dataFormat.parse(fields[2])));
            }
        }
        return results;
    }

    private int mark;

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }
}
