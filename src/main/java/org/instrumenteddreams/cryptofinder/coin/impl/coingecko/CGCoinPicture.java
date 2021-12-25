package org.instrumenteddreams.cryptofinder.coin.impl.coingecko;

import org.instrumenteddreams.cryptofinder.coin.CoinPicture;

import com.litesoftwares.coingecko.domain.Shared.Image;

public class CGCoinPicture implements CoinPicture {

    private final Image delegate;

    public CGCoinPicture(Image delegate) {

	this.delegate = delegate;
    }

    public boolean equals(Object o) {

	return delegate.equals(o);
    }

    @Override
    public String getLarge() {

	return delegate.getLarge();
    }

    @Override
    public String getSmall() {

	return delegate.getSmall();
    }

    @Override
    public String getThumb() {

	return delegate.getThumb();
    }

    public int hashCode() {

	return delegate.hashCode();
    }

    public String toString() {

	return delegate.toString();
    }

}
