--Paul Winter 409827 Daniel Toups 412364
from :: Int -> [Int]
from x = x : from (x+1)

drop_mult :: Int -> [Int] -> [Int]
drop_mult x xs = filter (\y -> mod y x /= 0) xs

dropall :: [Int] -> [Int]
dropall (x:xs) = x : dropall (drop_mult x xs)

primes :: [Int]
primes = dropall (from 2)

addlist :: [Int]
addlist = zipWith (\x y -> x * y) (drop 2 primes) (primes)

dropprimes :: [Int]
dropprimes =  (filter (\x -> x > 0) (zipWith comp (drop 1 primes) (addlist)))
    where
        comp :: Int -> Int -> Int
        comp x y    | x * x < y         = 0
                    | otherwise         = x
