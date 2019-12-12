package br.com.saga.choreography.controller;

import br.com.saga.choreography.jobs.contagem.services.Processo1Impl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mvictor - 12/12/2019
 */
@RestController
@RequestMapping("contagem")
@Slf4j
public class ContagemController {

    @Autowired
    private Processo1Impl processo1;

    @GetMapping("/processar")
    public ResponseEntity<String> processar() {
        return new ResponseEntity<>(processo1.adicionarMensagemSaga("Murilo Victor"), HttpStatus.OK);
    }

}
