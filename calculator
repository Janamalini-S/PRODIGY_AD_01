import { useState } from 'react'
import { Button } from "/components/ui/button"
import { Card, CardContent, CardHeader, CardTitle } from "/components/ui/card"

export default function Calculator() {
  const [display, setDisplay] = useState('0')
  const [firstOperand, setFirstOperand] = useState<number | null>(null)
  const [operator, setOperator] = useState<string | null>(null)
  const [waitingForSecondOperand, setWaitingForSecondOperand] = useState(false)

  const inputDigit = (digit: string) => {
    if (waitingForSecondOperand) {
      setDisplay(digit)
      setWaitingForSecondOperand(false)
    } else {
      setDisplay(display === '0' ? digit : display + digit)
    }
  }

  const inputDecimal = () => {
    if (waitingForSecondOperand) {
      setDisplay('0.')
      setWaitingForSecondOperand(false)
      return
    }

    if (!display.includes('.')) {
      setDisplay(display + '.')
    }
  }

  const clear = () => {
    setDisplay('0')
    setFirstOperand(null)
    setOperator(null)
    setWaitingForSecondOperand(false)
  }

  const performOperation = (nextOperator: string) => {
    const inputValue = parseFloat(display)

    if (firstOperand === null) {
      setFirstOperand(inputValue)
    } else if (operator) {
      const result = calculate(firstOperand, inputValue, operator)
      setDisplay(String(result))
      setFirstOperand(result)
    }

    setWaitingForSecondOperand(true)
    setOperator(nextOperator)
  }

  const calculate = (firstOperand: number, secondOperand: number, operator: string) => {
    switch (operator) {
      case '+':
        return firstOperand + secondOperand
      case '-':
        return firstOperand - secondOperand
      case '*':
        return firstOperand * secondOperand
      case '/':
        return firstOperand / secondOperand
      default:
        return secondOperand
    }
  }

  return (
    <Card className="w-full max-w-md mx-auto my-10">
      <CardHeader>
        <CardTitle className="text-2xl font-bold">Calculator</CardTitle>
      </CardHeader>
      <CardContent>
        <div className="grid grid-cols-4 gap-2">
          <div className="col-span-4 bg-gray-100 p-2 rounded mb-2">
            <div className="text-right text-2xl font-bold">{display}</div>
          </div>
          <Button onClick={() => clear()} variant="destructive">C</Button>
          <Button onClick={() => inputDigit('7')}>7</Button>
          <Button onClick={() => inputDigit('8')}>8</Button>
          <Button onClick={() => inputDigit('9')}>9</Button>
          <Button onClick={() => performOperation('/')}>/</Button>
          <Button onClick={() => inputDigit('4')}>4</Button>
          <Button onClick={() => inputDigit('5')}>5</Button>
          <Button onClick={() => inputDigit('6')}>6</Button>
          <Button onClick={() => performOperation('*')}>*</Button>
          <Button onClick={() => inputDigit('1')}>1</Button>
          <Button onClick={() => inputDigit('2')}>2</Button>
          <Button onClick={() => inputDigit('3')}>3</Button>
          <Button onClick={() => performOperation('-')}>-</Button>
          <Button onClick={() => inputDigit('0')}>0</Button>
          <Button onClick={() => inputDecimal()}>.</Button>
          <Button onClick={() => performOperation('=')}>=</Button>
          <Button onClick={() => performOperation('+')}>+</Button>
        </div>
      </CardContent>
    </Card>
  )
}
