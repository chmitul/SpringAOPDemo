package org.aop.demo.service;

import org.aop.demo.annotation.LogTest;
import org.springframework.stereotype.Service;

@Service
public class AopService
{
	Long result = 0L;

	public Long testing1()
	{
		for(int i = 0; i < 1000; i++)
		{
			result += i;
		}
		System.out.println("The sum of values from 0 -1000 is  :" + result);
		return result;
	}

	public Long testing2()
	{
		for(int i = 1000; i < 10000; i++)
		{
			result += i;
		}
		System.out.println("The sum of values from 1000 - 10000 is  :" + result);
		return result;
	}

	@LogTest
	public Long testing3()
	{
		for(int i = 10000; i < 100000; i++)
		{
			result += i;
		}
		System.out.println("The sum of values from 10000 - 100000 is  :" + result);
		return result;
	}

	public Long testing4()
	{
		for(int i = 100; i < 500000; i++)
		{
			result += i;
		}
		System.out.println("The sum of values from 100 - 500000 is  :" + result);
		return result;
	}

	public Long testing5(int a , int b)
	{
		for(int i = a; i < b; i++)
		{
			result += i;
		}
		System.out.println("The sum of values from a and b is  :" + result);
		return result;
	}
}
