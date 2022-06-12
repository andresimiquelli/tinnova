package com.andresimiquelli.tinnovaveiculos.services;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.andresimiquelli.tinnovaveiculos.dtos.VeiculoPostDTO;
import com.andresimiquelli.tinnovaveiculos.resources.exceptions.FieldMessage;
import com.andresimiquelli.tinnovaveiculos.utils.MarcaList;

public class VeiculoPostValidator implements ConstraintValidator<VeiculoPostValidation, VeiculoPostDTO>{

	@Override
	public void initialize(VeiculoPostValidation ann) {}
	
	@Override
	public boolean isValid(VeiculoPostDTO value, ConstraintValidatorContext context) {
		
		List<FieldMessage> list = new ArrayList<>();
		
		if(value.getMarca() != null) {
			List<String> marcas = MarcaList.get();			
			if(!marcas.contains(value.getMarca()))
				list.add(new FieldMessage("marca","Marca não encontrada"));
		}
		
		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		
		return list.isEmpty();
	}

}
