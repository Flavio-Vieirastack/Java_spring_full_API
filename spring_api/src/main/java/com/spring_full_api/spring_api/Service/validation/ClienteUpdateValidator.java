package com.spring_full_api.spring_api.Service.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.spring_full_api.spring_api.DTO.ClienteDTO;
import com.spring_full_api.spring_api.Domain.Cliente;
import com.spring_full_api.spring_api.Resources.exceptions.FieldMessage;
import com.spring_full_api.spring_api.repository.ClienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;

public class ClienteUpdateValidator implements ConstraintValidator<ClienteUpdate, ClienteDTO> {

    @Override
    public void initialize(ClienteUpdate ann) {
    }

    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private HttpServletRequest request;

    @Override
    public boolean isValid(ClienteDTO objDto, ConstraintValidatorContext context) {

        Map<String, String> map = (Map<String, String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);

        Integer uriId = Integer.parseInt(map.get("id"));

        List<FieldMessage> list = new ArrayList<>();

        Cliente aux = clienteRepository.findByEmail(objDto.getEmail());
        if (aux != null && !aux.getId().equals(uriId)) {
            list.add(new FieldMessage("Email", "email existente"));
        }

        for (FieldMessage e : list) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(e.getMessage())
                    .addPropertyNode(e.getFildName()).addConstraintViolation();
        }
        return list.isEmpty();
    }
}