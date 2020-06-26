### URI 1018 - Cédulas
### Autora: Ana Laura Fernandes de Oliveira
### Linguagem: Python 3
#receber input
x = int(input())
a = x
#declarar variaveis
nota100 = nota50 = nota20 = nota10 = nota5 = nota2 = nota1 = 0
#contabilizar notas
if(int(x/100) > 0):
    nota100 = int(x/100)
    x -= nota100 * 100 #subtrai o valor ja distribuido em notas da variavel x

if(int(x/50) > 0):
    nota50 = int(x/50)
    x -= nota50 * 50

if(int(x/20) > 0):
    nota20 = int(x/20)
    x -= nota20 * 20

if(int(x/10) > 0):
    nota10 = int(x/10)
    x -= nota10 * 10

if(int(x/5) > 0):
    nota5 = int(x/5)
    x -= nota5 * 5

if(int(x/2) > 0):
    nota2 = int(x/2)
    x -= nota2 * 2

if(x > 0):
    nota1 = x
print(a)
print(nota100, "nota(s) de R$ 100,00")
print(nota50, "nota(s) de R$ 50,00")
print(nota20, "nota(s) de R$ 20,00")
print(nota10, "nota(s) de R$ 10,00")
print(nota5, "nota(s) de R$ 5,00")
print(nota2, "nota(s) de R$ 2,00")
print(nota1, "nota(s) de R$ 1,00")