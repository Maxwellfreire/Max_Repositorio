package com.example.teste.max_store;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.teste.max_store.banco.PessoaBanco;
import com.example.teste.max_store.modelo.Pessoa;

import java.util.ArrayList;

public class BancoActivity extends AppCompatActivity {
    ListView listPessoas;
    Button btnNovoCadastro;
    Pessoa pessoa;
    PessoaBanco pessoaBanco;
    ArrayList<Pessoa> arrayListPessoa;
    ArrayAdapter<Pessoa> arrayAdapterPessoa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banco);
        listPessoas = (ListView) findViewById(R.id.listpessoas);
        registerForContextMenu(listPessoas);


        CardView btnNovoCadastro = (CardView) findViewById(R.id.btnNovoCadastro);

        btnNovoCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(BancoActivity.this, FormPessoa.class);
                startActivity(i);
            }
        });

        listPessoas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Pessoa pessoaEnviada = (Pessoa) arrayAdapterPessoa.getItem(position);

                Intent i = new Intent(BancoActivity.this,FormPessoa.class);
                i.putExtra("pessoa-enviada",pessoaEnviada);
                startActivity(i);
            }
        });

        listPessoas.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                pessoa = arrayAdapterPessoa.getItem(position);
                return false;
            }
        });

    }

    public void populaLista(){
        pessoaBanco = new PessoaBanco(BancoActivity.this);

        arrayListPessoa = pessoaBanco.selectAllPessoa();
        pessoaBanco.close();

        if(listPessoas != null){



            arrayAdapterPessoa = new ArrayAdapter<Pessoa>(BancoActivity.this,android.R.layout.simple_list_item_1,arrayListPessoa);

            listPessoas.setAdapter(arrayAdapterPessoa);

        }
    }

    protected void onResume(){
        super.onResume();
        populaLista();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        MenuItem mDelete = menu.add("Delete Registro");
        mDelete.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                long retornoDB;
                pessoaBanco = new PessoaBanco(BancoActivity.this);
                retornoDB = pessoaBanco.excluirPessoa(pessoa);
                pessoaBanco.close();

                if (retornoDB == -1){
                    alert("Erro de exclusão");
                }else{
                    alert("Registro excluido com sucesso");
                }
                populaLista();
                return false;
            }
        });
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    private void alert(String s){
        Toast.makeText(this,s,Toast.LENGTH_SHORT).show();

    }

}
