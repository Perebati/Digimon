package com.example.atividade.pull;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

// O DigimonPuller acessa a URL onde esta localizado os dados da API
// Digimon, logo depois realiza a requisicao de dados e salva o arquivo
// JSON em uma string. Logo depois realiza o retorno da string.
public class DigimonPuller {
    public static String run(String[] args)
    {
        try{
            URL u = new URL("https://digimon-api.vercel.app/api/digimon");
            HttpURLConnection hr = (HttpURLConnection) u.openConnection();
            if(hr.getResponseCode() == 200){
                InputStream im = hr.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(im));
                String line = br.readLine();
                return line;
            }
        }catch (Exception e)
        {
            System.out.println(e);
        }
        return null;
    }
}