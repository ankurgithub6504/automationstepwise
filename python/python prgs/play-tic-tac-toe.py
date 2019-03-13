import random
from colorama import init
init()
from colorama import Fore

def display_board(board):
    print(Fore.WHITE+board[0]+'|'+board[1]+'|'+board[2])
    print(Fore.WHITE+board[3]+'|'+board[4]+'|'+board[5])
    print(Fore.WHITE+board[6]+'|'+board[7]+'|'+board[8])

b = ['1','2','3','4','5','6','7','8','9']
b1 = ['_','_','_','_','_','_','_','_','_']
b2 = ['_','_','_','_','_','_','_','_','_']

def select_your_input():
    while(True):
    	print(Fore.WHITE)
    	myInput = input('What would you like to take X or 0 ?')
    	if myInput =='X' or myInput =='0':
    		break
    	else:
    		print(Fore.RED+'Please select valid input out of X or 0 only...')
    return myInput

'''
This function is to take the position as input.

'''

# This function is for same as the below funtion, but in this we are not using try/except block to handle the special characters as input
def select_your_position1():
    while(True):
    	print(Fore.WHITE)
    	pos = input('Please select your position number [in 1-9]')
    	if pos.isnumeric() and int(pos)>0 and int(pos)<=9:
    		break
    	else:
    		print(Fore.RED+'Please provide valid position number out of 1 to 9 only..')
    return pos

'''
This function is to take the position as input.

'''
# Here we are using try/except block to handle the special characters as input
def select_your_position():
    while(True):
    	print(Fore.WHITE)
    	try:
    		pos = int(input('Please select your position number [in 1-9]'))
    		if pos>0 and pos<=9:
    			break
    		else:
    			print(Fore.RED+'Please provide valid position number out of 1 to 9 only..')
    	except ValueError:
    		print(Fore.RED+'This is not a number, please give it carefully..')
    		continue
    return pos


def want_to_play():
    wantToPlay = input('Do you want to play tic tac toe ?')
    if wantToPlay == 'yes' or wantToPlay == 'y':
        return True
    else:
        return False

def get_random_number(num1,num2):
	ran = random.randint(num1, num2)
	return ran

def check_number_in_list(num,lst):
	if num in lst:
		return True
	else:
		return False

def check_success(lst,s):
	#print('in--')
	#print(lst)
	if lst[0] == s and lst[1] == s and lst[2] == s:
		return True
	elif lst[3] == s and lst[4] == s and lst[5] == s:
		return True
	elif lst[6] == s and lst[7] == s and lst[8] == s:
		return True
	elif lst[0] == s and lst[4] == s and lst[8] == s:
		return True
	elif lst[0] == s and lst[3] == s and lst[6] == s:
		return True
	elif lst[1] == s and lst[4] == s and lst[7] == s:
		return True
	elif lst[2] == s and lst[5] == s and lst[8] == s:
		return True
	elif lst[2] == s and lst[4] == s and lst[6] == s:
		return True
	else:
		return False


def play_tic_tac_toe():
	mySide = 'X'
	posList = ['','','','','','','','','','']
	b3 = ['_','_','_','_','_','_','_','_','_']
	#winList = [[1,2,3],[4,5,6],[7,8,9],[1,4,7],[2,5,8],[3,6,9],[1,5,9],[3,5,7]] #[{1,2,3},{4,5,6},{7,8,9},{1,4,7},{2,5,8},{3,6,9},{1,5,9},{3,5,7}]
	#mm = ['','','']
	#index = 0

	b1=b2
	display_board(b)

	if want_to_play():
		side = select_your_input()

		for step in range(1,10):
			if step%2 == 1:
				#print('Step is {}'.format(step))
				while(True):
					pos = select_your_position()
					if str(pos) in posList:
						print(Fore.RED+'This position is occupied already, please select an empty position.')
						continue
					else:
						posList[int(step)-1]=str(pos)
						b3[int(posList[int(step)-1])-1] = side
						display_board(b3)
						break
			else:
				#print('Step is {}'.format(step))
				if side == 'X':
					mySide = '0'
				while(True):
					n = get_random_number(1,9)
					print('-----------------------')
					#print('random number is {}'.format(n))
					if str(n) in posList:
						#print('number already exists')
						continue
					else:
						posList[int(step)-1]=str(n)
						break
				b3[int(posList[int(step)-1])-1] = mySide
				display_board(b3)
				#print(posList)

			if check_success(b3,side):
				print(Fore.GREEN+'CONGRATULATIONS, YOU WIN!!!')
				break
			if check_success(b3,mySide):
				print(Fore.RED+'SORRY, YOU LOSE!!!')
				break

	else:
		print('Thanks for not playing!!!')


def run_opponent(lst,pos,s):

	if pos%3 == 1:
		if lst[pos+1] == '_':
			lst[pos+1] = s
		elif lst[pos+2] == '_':
			lst[pos+2] = s
	elif pos%3 == 2:
		if lst[pos-1] == '_':
			lst[pos-1] = s
		elif lst[pos+1] == '_':
			lst[pos+1] = s
	elif pos%3 == 0:
		if lst[pos-1] == '_':
			lst[pos-1] = s
		elif lst[pos-2] == '_':
			lst[pos-2] = s

play_tic_tac_toe()