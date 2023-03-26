package dta.myorganize.controller;

import dta.myorganize.service.SubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/subcategory")
public class SubCategoryController {
    @Autowired
    SubCategoryService subCategoryService;
}
