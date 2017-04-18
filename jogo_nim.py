def computador_escolhe_jogada(n,m):
	if n<=m: return n
	elif n%(m+1)>0: return n%(m+1)
	else: return m
def usuario_escolhe_jogada(n,m):
	valor=int(input("\nQuantas peças você vai tirar? "))
	while valor>m or valor<=0 or valor>n: valor=int(input("Oops! Jogada inválida! Tente de novo.\nQuantas peças você vai tirar? "))
	return valor
def partida():
	n=int(input("Quantas peças? "))
	while(n<1): n=int(input("Número de peças inválido\nQuantas peças? "))
	m=int(input("Limite de peças por jogada? "))
	while m<1: m=int(input("Número de peças inválido\nLimite de peças por jogada? "))
	if (n%(m+1))==0:
		print("\nVocê começa!")
		jogada=1
		while n>0:
			if jogada==1:
				valor=usuario_escolhe_jogada(n,m)
				n=n-valor
				print("\nVocê tirou",valor,"peça(s).\nAgora restam",n,"peças no tabuleiro.")
				jogada=2
			else:
				valor=computador_escolhe_jogada(n,m)
				n=n-valor
				print("\nO computador tirou",valor,"peça(s)\nAgora restam",n,"peças no tabuleiro.")
				jogada=1
		print("\nFim do jogo! O computador ganhou!\n")
	else:
		print("\nComputador começa!")
		jogada=2
		while n>0:
			if jogada==2:
				valor=computador_escolhe_jogada(n,m)
				n=n-valor
				print("\nO computador tirou",valor,"peça(s)\nAgora restam",n,"peças no tabuleiro.")
				jogada=1
			else:
				valor=usuario_escolhe_jogada(n,m)
				n=n-valor
				print("\nVocê tirou",valor,"peça(s).\nAgora restam",n,"peças no tabuleiro.")
				jogada=2
		print("\nFim do jogo! O computador ganhou!\n")
def campeonato():
	quantidade_partida=1
	while quantidade_partida<4:
		print("**** Rodada",quantidade_partida,"****\n")
		partida()
		quantidade_partida+=1
	print("**** Final do campeonato! ****\n\nPlacar: Você 0 X 3 Computador")
escolha=int(input("Bem-vindo ao jogo do NIM!\n1 - para jogar uma partida isolada\n2 - para jogar um campeonato\nEscolha: "))    
while escolha!=1 and escolha!=2:
	escolha=int(input("Escolha uma opção válida!\nEscolha: "))
if escolha==1:
	print("\nVocê escolheu uma partida isolada!\n")
	partida()
else:
	print("\nVocê escolheu um campeonato!\n")
	campeonato()
