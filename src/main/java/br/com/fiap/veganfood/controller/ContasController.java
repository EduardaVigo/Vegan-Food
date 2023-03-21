package br.com.fiap.VeganFood.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.VeganFood.models.Conta;
import br.com.fiap.VeganFood.models.Categoria;

@RestController
public class ContasController {

    List<Conta> Contas = new ArrayList<Conta>();

    @GetMapping("api/Contas")
    public List<Conta> listarContas() {
        return Contas;
    }

    @PostMapping("api/conta")
    public ResponseEntity<Conta> cadastrar(@RequestBody Conta conta) {

        conta.setId(Contas.size() + 1);

        Contas.add(conta);

        return ResponseEntity.status(HttpStatus.CREATED).body(conta);

    }

    @GetMapping("api/conta")
    public Conta show() {

        return new Conta("Foto de perfil", "Usuário 1", "Comida Japonesa", Categoria.Cliente, null,
                null);

    }


    @GetMapping("api/conta/{id}")
    public ResponseEntity<Conta> retornaComId(@PathVariable Integer id) {

        Optional<Conta> contaContainer = Contas.stream().filter((Conta conta) -> conta.getId().equals(id))
                .findFirst();

        if (contaContainer.isPresent()) {
            return ResponseEntity.ok(contaContainer.get());
        }

        return ResponseEntity.notFound().build();

    }

    @PutMapping("api/conta/{id}")
    public ResponseEntity<Conta> updateById(@PathVariable Integer id, @RequestBody Conta vegan) {

        Optional<Conta> contaContainer = Contas.stream().filter((Conta conta) -> conta.getId().equals(id))
                .findFirst();

        
        if (contaContainer.isPresent()) {

                 contaContainer.get().setFoto(art.getFoto());
                 contaContainer.get().setNome(art.getNome());   
                 
                 return ResponseEntity.ok(contaContainer.get());   
            
        }
        
        return ResponseEntity.notFound().build();

    }


    @DeleteMapping("aapi/conta/{id}")
    public ResponseEntity<Conta> deletaComId(@PathVariable Integer id) {

        Optional<Conta> contaContainer = Contas.stream().filter((Conta conta) -> conta.getId().equals(id))
                .findFirst();

        if (contaContainer.isPresent()) {
            Contas.remove(ContaContainer.get());
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();

    }

}
