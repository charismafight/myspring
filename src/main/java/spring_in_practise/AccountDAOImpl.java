package spring_in_practise;

import org.springframework.core.io.Resource;

import java.io.BufferedReader;
import java.io.FileReader;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AccountDAOImpl implements AccountDAO {
    private Resource csvResource;

    public void setCsvResource(Resource csvFile) {
        this.csvResource = csvFile;
    }

    @Override
    public List<Account> findAll() throws Exception {
        var results = new ArrayList<Account>();
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
}
