/***************************************************************************
 *   This file is part of Robocut.                                         *
 *   Copyright (C) 2010 Tim Hutt <tdhutt@gmail.com>                        *
 *   Copyright (C) 2010 Markus Schulz <schulz@alpharesearch.de>            *
 *                                                                         *
 *   This program is free software; you can redistribute it and/or modify  *
 *   it under the terms of the GNU General Public License as published by  *
 *   the Free Software Foundation; either version 3 of the License, or     *
 *   (at your option) any later version.                                   *
 *                                                                         *
 *   This program is distributed in the hope that it will be useful,       *
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of        *
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the         *
 *   GNU General Public License for more details.                          *
 *                                                                         *
 *   You should have received a copy of the GNU General Public License     *
 *   along with this program; if not, write to the                         *
 *   Free Software Foundation, Inc.,                                       *
 *   51 Franklin St, Fifth Floor, Boston, MA 02110-1301, USA.              *
 ***************************************************************************/


//void PathPaintEngine::drawPath(const QPainterPath& path)
void PathPaintEngine::drawPath(const QPainterPath path)
{
	if (!dev)
		return;

	if(!isCosmetic)
	{
		QList<QPolygonF> polys = path.toSubpathPolygons();
		for (int i = 0; i < polys.size(); ++i)
		{
			if(dashPattern.empty()) dev->addPath(transform.map(polys[i]));
			else
			{
				QPolygonF polytemp = transform.map(polys[i]), newpoly;
				int  dashtoggle = 1, dashi=0, j = 0;
				qreal actualdashsize = dashPattern[dashi];
				QPointF origin = QPointF(polytemp[j]), testp;
				j++;
				do
				{
					newpoly = QPolygonF();
					newpoly.append(origin);
					do
					{
						testp = polytemp[j];
						origin = QPointF(getPointAtLenght(QPointF(origin), polytemp[j], actualdashsize));
						if (essentiallyEqual(origin.x(), polytemp[j].x(), 0.01 ) && approximatelyEqual(origin.y(), polytemp[j].y(),0.01) && j+1 < polytemp.size())
						{
							origin = polytemp[j];
							j++;
							testp =  polytemp[j];
						}
						newpoly.append(origin);

					}while(definitelyGreaterThan(actualdashsize,0.0,0.1) && testp!=origin);
					if(dashtoggle == 1)
					{
						dev->addPath(newpoly);
					}
					dashtoggle = dashtoggle * -1;
					dashi++;
					if(dashi >= dashPattern.size()) dashi=0;
					actualdashsize = dashPattern[dashi];
				}while(!essentiallyEqual(origin.x(), polytemp[j].x(), 0.001 ) || !essentiallyEqual(origin.y(), polytemp[j].y(),0.001));
			}
		}
	}
}