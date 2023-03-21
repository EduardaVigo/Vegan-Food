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

import br.com.fiap.VeganFood.models.Despesa;
import br.com.fiap.VeganFood.models.Categoria;

@RestController
public class DespesasController {

    List<Despesa> Despesas = new ArrayList<Despesa>();

    @GetMapping("api/Despesas")
    public List<Despesa> listarDespesas() {
        return Despesas;
    }

    @PostMapping("api/despesa")
    public ResponseEntity<Despesa> cadastrar(@RequestBody Despesa despesa) {

        despesa.setId(Despesas.size() + 1);

        Despesas.add(despesa);

        return ResponseEntity.status(HttpStatus.CREATED).body(despesa);

    }

    @GetMapping("api/despesa")
    public Despesa show() {

        return new Despesa("Valor", "Data", Conta.Id , Categoria.Id, "Despesa referente ao dia 03/12",
                null);

    }


    @GetMapping("api/despesa/{id}")
    public ResponseEntity<Despesa> retornaComId(@PathVariable Integer id) {

        Optional<Despesa> despesaContainer = Despesas.stream().filter((Despesa despesa) -> despesa.getId().equals(id))
                .findFirst();

        if (despesaContainer.isPresent()) {
            return ResponseEntity.ok(despesaContainer.get());
        }

        return ResponseEntity.notFound().build();

    }

    @PutMapping("api/despesa/{id}")
    public ResponseEntity<Despesa> updateById(@PathVariable Integer id, @RequestBody Despesa vegan) {

        Optional<Despesa> despesaContainer = Despesas.stream().filter((Despesa despesa) -> despesa.getId().equals(id))
                .findFirst();

        
        if (despesaContainer.isPresent()) {

                 despesaContainer.get().setFoto(art.getValor());
                 despesaContainer.get().setNome(art.getData());   
                 
                 return ResponseEntity.ok(despesaContainer.get());   
            
        }
        
        return ResponseEntity.notFound().build();

    }


    @DeleteMapping("aapi/despesa/{id}")
    public ResponseEntity<Despesa> deletaComId(@PathVariable Integer id) {

        Optional<Despesa> despesaContainer = Despesas.stream().filter((Despesa despesa) -> despesa.getId().equals(id))
                .findFirst();

        if (despesaContainer.isPresent()) {
            Despesas.remove(DespesaContainer.get());
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();

    }

}
