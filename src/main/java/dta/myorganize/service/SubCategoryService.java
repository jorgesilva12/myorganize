package dta.myorganize.service;

import dta.myorganize.repository.SubCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubCategoryService {
    @Autowired
    SubCategoryRepository subCategoryRepository;
}
