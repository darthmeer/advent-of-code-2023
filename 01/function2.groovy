#!/usr/bin/groovy

def lines = []
def digits, first, last, lastSize, combined, originalLine

def numberExchanger = [
  one: 1,
  two: 2,
  three: 3,
  four: 4,
  five: 5,
  six: 6,
  seven: 7,
  eight: 8,
  nine: 9
]

new File('input.txt').eachLine { line ->

  // loop through converter map
  originalLine = line
  numberExchanger.each { word, number ->
    line = line.replaceAll(word, number.toString())
  }

  digits = line.findAll(/\d+/)*.toInteger()
  first = digits.first().toString().substring(0, 1)
  lastSize = digits.last().toString().size()
  last = digits.last().toString().substring(lastSize-1, lastSize)
  combined = (first + last).toInteger()
  lines.add(combined)

  println("line: " + originalLine + ", new: " + line + ", combined: " + combined)

}

println(lines.sum())
