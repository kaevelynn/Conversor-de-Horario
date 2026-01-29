Olá, A aplicação disponibiliza uma API local que recebe um horário em formato JSON e retorna o horário convertido.(PM - AM) - (24h)

Exemplo--
Invoke-WebRequest -Uri http://localhost:8080/ `
  -Method POST `
  -Body '{"horario": "22:32:22"}' `
  -ContentType "application/json"

Saída esperada -
{
  "resultado": "10:32:22 PM"
}


-------------------------------------------------------------------------------------------------------
O servidor deve estar em execução localmente na porta 8080 para que a requisição funcione corretamente.
-------------------------------------------------------------------------------------------------------
