package dev.paintilya.quebectaxcalculator.DAL;

import dev.paintilya.quebectaxcalculator.BLL.Model.TaxBracket;

import java.util.List;

public interface ITaxBracketDAO {
    public List<TaxBracket> findAll();
    public TaxBracket findByRate(float rate);
}
